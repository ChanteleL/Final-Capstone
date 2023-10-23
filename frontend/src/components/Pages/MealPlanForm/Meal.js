import React from "react";
import { Stack, TextField, Button, useTheme } from "@mui/material";
import { RemoveCircle } from "@mui/icons-material";
import { useDispatch, useSelector } from "react-redux";
import {
  setMealTitle,
  removeMeal,
} from "../../../redux/features/forms/mealplan/mealPlanDataSlice";
import MealRecipesList from "./MealRecipesList";

const mealStyles = {
  "& .MuiInputBase-input": {
    textAlign: "center",
  },
  width: "70%",
  margin: "0 auto",
};

const Meal = ({ mealIndex, dayIndex }) => {
  const dispatch = useDispatch();
  const theme = useTheme();
  const mealTitle = useSelector(
    (state) => state.mealPlanData.days[dayIndex].meals[mealIndex].title
  );

  return (
    <Stack
      sx={{
        border: `1px solid ${theme.palette.text.main}`,
        borderRadius: "10px",
        padding: "5px",
        minHeight: "140px",
        mb: 1,
        position: "relative",
        "&:not(:first-of-type)": {
          mt: 1,
        },
      }}
    >
      <TextField
        variant="standard"
        value={mealTitle}
        sx={mealStyles}
        onChange={(e) =>
          dispatch(setMealTitle({ title: e.target.value, dayIndex, mealIndex }))
        }
        placeholder="Meal title"
      ></TextField>
      <Stack alignItems="center">
        <MealRecipesList mealIndex={mealIndex} dayIndex={dayIndex} />
      </Stack>
      <Button
        onClick={() => dispatch(removeMeal({ dayIndex, mealIndex }))}
        sx={{ position: "absolute", top: "0px", left: "-15px" }}
      >
        <RemoveCircle
          color="warning"
          sx={{
            fontSize: "20px",
            mt: 0.5,
          }}
        />
      </Button>
    </Stack>
  );
};

export default Meal;

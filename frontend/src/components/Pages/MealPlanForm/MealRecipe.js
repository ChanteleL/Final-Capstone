import React from "react";
import { Stack, Button, Typography } from "@mui/material";
import { RemoveCircle } from "@mui/icons-material";
import { useDispatch } from "react-redux";
import { removeRecipeFromMeal } from "../../../redux/features/forms/mealplan/mealPlanDataSlice";

const MealRecipe = ({ recipe, dayIndex, mealIndex, recipeIndex }) => {
  const dispatch = useDispatch();

  return (
    <Stack direction="row" alignItems="center" sx={{ mt: 2, width: "100%" }}>
      <Button
        sx={{ p: 0, minWidth: "35px" }}
        onClick={() =>
          dispatch(removeRecipeFromMeal({ dayIndex, mealIndex, recipeIndex }))
        }
      >
        <RemoveCircle
          color="warning"
          sx={{
            fontSize: "17px",
          }}
        />
      </Button>
      <Stack
        sx={{ width: "calc(100% - 20px)" }}
        direction="row"
        alignItems="center"
      >
        <Typography sx={{ mr: 1 }}>{recipe.servings}</Typography>
        <Typography sx={{ width: "calc(100% - 35px)", overflow: "hidden" }}>
          {recipe.name.length > 16
            ? recipe.name.substring(0, 16) + "..."
            : recipe.name}
        </Typography>
      </Stack>
    </Stack>
  );
};

export default MealRecipe;

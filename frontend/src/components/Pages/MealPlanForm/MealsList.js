import React from "react";
import Meal from "./Meal";
import { Stack, Button } from "@mui/material";
import { AddCircleOutline } from "@mui/icons-material";
import { useDispatch, useSelector } from "react-redux";
import { addMeal } from "../../../redux/features/forms/mealplan/mealPlanDataSlice";

const MealsList = ({ dayIndex }) => {
  const dispatch = useDispatch();
  const meals = useSelector(
    (state) => state.mealPlanData.days[dayIndex]?.meals
  );

  const mealComponents = meals?.map((meal, mealIndex) => (
    <Meal dayIndex={dayIndex} mealIndex={mealIndex} key={mealIndex} />
  ));

  return (
    <Stack sx={{ mt: 3 }}>
      {mealComponents}
      <Button onClick={() => dispatch(addMeal(dayIndex))}>
        <AddCircleOutline />
      </Button>
    </Stack>
  );
};

export default MealsList;

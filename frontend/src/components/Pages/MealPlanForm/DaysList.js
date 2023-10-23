import React from "react";
import Day from "./Day";
import { Stack, Button, useMediaQuery } from "@mui/material";
import { AddCircleOutline } from "@mui/icons-material";
import { useSelector, useDispatch } from "react-redux";
import { addDay } from "../../../redux/features/forms/mealplan/mealPlanDataSlice";

const DaysList = () => {
  const dispatch = useDispatch();
  const days = useSelector((state) => state.mealPlanData.days);
  const matches = useMediaQuery("(max-width: 599px)");

  const dayComponents = days.map((day, dayIndex) => (
    <Day key={dayIndex} dayIndex={dayIndex} />
  ));

  return (
    <>
      <Stack
        direction="row"
        sx={{
          flexWrap: "wrap",
          flexDirection: matches ? "column" : "row",
          alignItems: matches ? "center" : "",
        }}
      >
        {dayComponents}
        <Button
          onClick={() => dispatch(addDay())}
          sx={{ width: "100%", ml: 2, maxWidth: "250px", height: "600px" }}
        >
          <AddCircleOutline sx={{ fontSize: "45px" }} />
        </Button>
      </Stack>
    </>
  );
};

export default DaysList;

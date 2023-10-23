import React from "react";
import { Stack, Typography, Button, Box, useTheme } from "@mui/material";
import { RemoveCircle } from "@mui/icons-material";
import { useDispatch } from "react-redux";
import { removeDay } from "../../../redux/features/forms/mealplan/mealPlanDataSlice";
import MealsList from "./MealsList";

const Day = ({ dayIndex }) => {
  const dispatch = useDispatch();
  const theme = useTheme();

  const hideScroll = {
    border: `1px solid ${theme.palette.text.main}`,
    borderRadius: "10px",
    width: "100%",
    maxWidth: "280px",
    height: "600px",
    position: "relative",
    overflow: "hidden",
  };

  return (
    <Box sx={{ ml: 2, mb: 3 }} style={hideScroll}>
      <Stack
        alignItems="center"
        sx={{
          overflow: "auto",
          padding: "0 10px",
          height: "100%",
        }}
      >
        <Box>
          <Typography sx={{ mt: 3 }} variant="h5" element="h4">
            {`Day ${dayIndex + 1}`}
          </Typography>
          <Button
            sx={{
              position: "absolute",
              top: "25px",
              left: "-5px",
            }}
            onClick={() => dispatch(removeDay(dayIndex))}
          >
            <RemoveCircle color="warning" sx={{ fontSize: "25px" }} />
          </Button>
        </Box>
        <Stack sx={{ width: "100%" }}>
          <MealsList dayIndex={dayIndex} />
        </Stack>
      </Stack>
    </Box>
  );
};

export default Day;

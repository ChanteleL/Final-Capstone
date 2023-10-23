import React, { useEffect, useState } from "react";
import { useSelector, useDispatch } from "react-redux";
import { useParams } from "react-router-dom";
import axios from "axios";
import Layout from "../../Layout/Layout";
import MealPlanForm from "../MealPlanForm/MealPlanForm";
import { CircularProgress } from "@mui/material";
import { setMealPlanFormData } from "../../../redux/features/forms/mealplan/mealPlanDataSlice";
import {
  setErrorMsg,
  setShowError,
} from "../../../redux/features/forms/errors/errorsSlice";

const EditMealPlan = () => {
  const currUserId = useSelector((state) => state.auth.user.id);
  const token = useSelector((state) => state.auth.token);
  const { id } = useParams();
  const [mealPlan, setMealPlan] = useState();
  const [isMealPlanLoaded, setIsMealPlanLoaded] = useState(false);
  const [isAuthorized, setIsAuthorized] = useState(false);
  const dispatch = useDispatch();

  useEffect(() => {
    axios
      .get(process.env.REACT_APP_SERVER_URL + `/mealplans/${id}`, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      })
      .then((res) => setMealPlan(res.data))
      .catch((err) => {
        if (err.response?.data?.message) {
          dispatch(setErrorMsg(err.response.data.message));
        } else if (err.response?.statusText) {
          dispatch(setErrorMsg(err.response.statusText));
        } else if (err.request) {
          dispatch(setErrorMsg("Network error."));
        } else {
          dispatch(setErrorMsg("Error"));
        }
        dispatch(setShowError(true));
      })
      .then(() => setIsMealPlanLoaded(true));
  }, [dispatch, id, token]);

  useEffect(() => {
    if (isMealPlanLoaded && isAuthorized) {
      dispatch(setMealPlanFormData(mealPlan));
    }
  }, [isMealPlanLoaded, isAuthorized, dispatch, mealPlan]);

  useEffect(() => {
    if (isMealPlanLoaded) {
      if (mealPlan?.creatorId === currUserId) {
        setIsAuthorized(true);
      } else {
        setIsAuthorized(false);
      }
    }
  }, [isMealPlanLoaded, currUserId, mealPlan?.creatorId]);

  return (
    <Layout>
      {!isMealPlanLoaded && <CircularProgress />}
      {isMealPlanLoaded && isAuthorized && <MealPlanForm isEdit={true} />}
    </Layout>
  );
};

export default EditMealPlan;

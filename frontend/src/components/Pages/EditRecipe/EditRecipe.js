import React, { useEffect, useState } from "react";
import { useSelector, useDispatch } from "react-redux";
import { useParams } from "react-router-dom";
import axios from "axios";
import { CircularProgress } from "@mui/material";
import Layout from "../../Layout/Layout";
import EditRecipeForm from "../RecipeForm/EditRecipeForm";
import { setRecipeFormData } from "../../../redux/features/forms/addrecipe/addRecipeDataSlice";
import {
  setErrorMsg,
  setShowError,
} from "../../../redux/features/forms/errors/errorsSlice";

const EditRecipe = () => {
  const currUserId = useSelector((state) => state.auth.user.id);
  const token = useSelector((state) => state.auth.token);
  const { id } = useParams();
  const [recipe, setRecipe] = useState();
  const [isRecipeLoaded, setIsRecipeLoaded] = useState(false);
  const [isAuthorized, setIsAuthorized] = useState(false);
  const dispatch = useDispatch();

  useEffect(() => {
    axios
      .get(process.env.REACT_APP_SERVER_URL + `/recipes/${id}`, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      })
      .then((res) => setRecipe(res.data))
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
      .then(() => setIsRecipeLoaded(true));
  }, [dispatch, id, token]);

  useEffect(() => {
    if (isRecipeLoaded && isAuthorized) {
      dispatch(setRecipeFormData(recipe));
    }
  }, [isRecipeLoaded, isAuthorized, dispatch, recipe]);

  useEffect(() => {
    if (isRecipeLoaded) {
      if (recipe.creatorId === currUserId) {
        setIsAuthorized(true);
      } else {
        setIsAuthorized(false);
      }
    }
  }, [isRecipeLoaded, currUserId, recipe?.creatorId]);

  return (
    <Layout>
      {!isRecipeLoaded && <CircularProgress />}
      {isRecipeLoaded && isAuthorized && <EditRecipeForm />}
    </Layout>
  );
};

export default EditRecipe;

//update the add recipe data in state
//render out the addrecipe component, call it RecipeForm
// pass in that it is an edit, handle submit as a put, with id

import React, { useState } from "react";
import {
  Stack,
  InputLabel,
  TextField,
  FormControl,
  RadioGroup,
  FormControlLabel,
  Radio,
  Typography,
  CircularProgress,
  Button,
} from "@mui/material";
import Layout from "../../Layout/Layout";
import axios from "axios";
import { useSelector, useDispatch } from "react-redux";
import {
  setShowSuccess,
  setSuccessMsg,
  setErrorMsg,
  setShowError,
} from "../../../redux/features/forms/errors/errorsSlice";
import PageTitle from "../../shared/PageTitle";
import PageLayout from "../../shared/PageLayout";

const AddIngredient = () => {
  const [name, setName] = useState("");
  const [liquid, setLiquid] = useState(false);
  const [isLoading, setIsLoading] = useState();
  const dispatch = useDispatch();

  const token = useSelector((state) => state.auth.token);

  const handleSubmit = () => {
    const postData = { name, liquid };
    setIsLoading(true);
    axios
      .post(process.env.REACT_APP_SERVER_URL + `/ingredient`, postData, {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      })
      .then((res) => {
        dispatch(setSuccessMsg(`Added ingredient ${name}!`));
        dispatch(setShowSuccess(true));
      })
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
      .then(() => {
        setIsLoading(false);
        clearFormState();
      });
  };

  const clearFormState = () => {
    setName("");
    setLiquid("");
  };

  return (
    <Layout>
      <PageLayout>
        <Stack sx={{ maxWidth: "500px", width: "100%" }}>
          <PageTitle title="Add Ingredient" />
          <form>
            <Stack sx={{ width: "100%", transform: "scale(0.9)" }}>
              <InputLabel>Name</InputLabel>
              <TextField
                value={name}
                onChange={(e) => {
                  const { value } = e.target;
                  const re = /^[A-Za-z]+$/;
                  if (value === "" || re.test(value)) {
                    setName(value);
                  }
                }}
                sx={{ mt: 1 }}
                placeholder="Ingredient name"
              ></TextField>
              <FormControl sx={{ mt: 3 }}>
                <Typography>Is it a liquid?</Typography>
                <RadioGroup
                  defaultValue="no"
                  name="radio-buttons-group"
                  value={liquid}
                  onChange={(e) => setLiquid(e.target.value)}
                >
                  <FormControlLabel
                    value={true}
                    control={<Radio />}
                    label="Yes"
                  />
                  <FormControlLabel
                    value={false}
                    control={<Radio />}
                    label="No"
                  />
                </RadioGroup>
              </FormControl>
              <Button sx={{ mt: 3 }} onClick={handleSubmit} variant="btn">
                {isLoading ? <CircularProgress /> : "Add Ingredient"}
              </Button>
            </Stack>
          </form>
        </Stack>
      </PageLayout>
    </Layout>
  );
};

export default AddIngredient;

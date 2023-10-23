import React from "react";
import {
  NavLink as ReactNavLink,
  Link as ReactLink,
  useNavigate,
} from "react-router-dom";
import { Button, Stack, useTheme, Box, Link } from "@mui/material";
import { deleteUser, addToken } from "../../redux/features/auth/authSlice";
import { useDispatch, useSelector } from "react-redux";
import circleLogo from "../../assets/logo-circle.svg";
import LogoutIcon from "@mui/icons-material/Logout";

const Sidebar = () => {
  const theme = useTheme();
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const roles = useSelector((state) => state.auth.user.appUserRoles);
  const isAdmin = roles?.some(
    (role) => role.name === "ROLE_ADMIN" || role.name === "ROLE_SUPER_ADMIN"
  );
  const isXs = useSelector((state) => state.layout.isXs);

  const sidebar = {
    width: isXs ? "300px" : "280px",
    backgroundColor: theme.palette.primary.light,
    height: "100%",
  };

  const linkStyles = {
    width: "100%",
    textDecoration: "none",
  };

  return (
    <Stack alignItems="center" sx={sidebar}>
      <Box sx={{ mt: 5 }}>
        <Link component={ReactLink} to="/">
          <Box
            component="img"
            sx={{ maxWidth: isXs ? "130px" : "170px", width: "100%" }}
            src={circleLogo}
            alt="Meal Planner Logo"
          />
        </Link>
      </Box>
      <Button
        to="/allrecipes"
        sx={{ ...linkStyles, mt: 4 }}
        component={ReactNavLink}
        variant="nav-link"
      >
        All Recipes
      </Button>
      <Button
        to="/addrecipe"
        sx={linkStyles}
        component={ReactNavLink}
        variant="nav-link"
      >
        Add Recipe
      </Button>
      <Button
        to="/myrecipes"
        sx={linkStyles}
        component={ReactNavLink}
        variant="nav-link"
      >
        My Recipes
      </Button>
      <Button
        to="/mealplans/add"
        sx={linkStyles}
        component={ReactNavLink}
        variant="nav-link"
      >
        Create Meal Plan
      </Button>
      <Button
        to="/mymealplans"
        sx={linkStyles}
        component={ReactNavLink}
        variant="nav-link"
      >
        My Meal Plans
      </Button>
      {isAdmin && (
        <Button
          to="/category/add"
          sx={linkStyles}
          component={ReactNavLink}
          variant="nav-link"
        >
          Add Category
        </Button>
      )}
      {isAdmin && (
        <Button
          to="/ingredient/add"
          sx={linkStyles}
          component={ReactNavLink}
          variant="nav-link"
        >
          Add Ingredient
        </Button>
      )}
      <Button
        onClick={() => {
          dispatch(deleteUser());
          dispatch(addToken(null));
          navigate("/");
        }}
        variant="nav-link"
        sx={{ ...linkStyles, mt: "auto", mb: 2 }}
      >
        Logout
        <LogoutIcon fontSize="small" sx={{ ml: 2 }} />
      </Button>
    </Stack>
  );
};

export default Sidebar;

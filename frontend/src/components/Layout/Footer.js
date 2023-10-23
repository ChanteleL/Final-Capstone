import { Box, useTheme, Link, Typography } from "@mui/material";
import React, { useState, useEffect } from "react";
import { useSelector } from "react-redux";
import { useLocation } from "react-router-dom";

const Footer = () => {
  const isLg = useSelector((state) => state.layout.isLg);
  const location = useLocation();
  const [isLocationHome, setIsLocationHome] = useState(false);
  const theme = useTheme();

  const footer = (theme) => ({
    backgroundColor: theme.palette.warning.main,
    width: "100%",
    padding: "15px",
    height: "100%",
    pl: !isLg || isLocationHome ? "" : "320px",
  });

  useEffect(() => {
    if (location.pathname === "/") {
      setIsLocationHome(true);
    }
  }, [location]);

  const textLink = {
    color: "#fff",
    cursor: "pointer",
    textDecorationThickness: "2px",
    textDecorationColor: theme.palette.primary.dark,
    "&:hover": {
      color: theme.palette.primary.dark,
    },
  };

  return (
    <Box sx={footer}>
      <Box>
        <Typography
          variant="h4"
          textAlign="center"
          sx={{
            color: `${theme.palette.white.main}`,
            fontSize: isLg ? "22px" : "18px",
            letterSpacing: "1px",
          }}
        >
          Created by{" "}
          <Link
            target="_blank"
            sx={textLink}
            href="https://linkedin.com/in/edward-cleary"
          >
            Edward Cleary
          </Link>
          ,{" "}
          <Link
            target="_blank"
            sx={textLink}
            href="https://linkedin.com/in/chantele-lohr"
          >
            Chantele Lohr
          </Link>
          , and{" "}
          <Link
            target="_blank"
            sx={textLink}
            href="https://linkedin.com/in/brandynvo"
          >
            Brandon Vo
          </Link>
        </Typography>
      </Box>
    </Box>
  );
};

export default Footer;

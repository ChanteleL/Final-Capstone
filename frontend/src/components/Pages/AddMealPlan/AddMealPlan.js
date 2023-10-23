import React from "react";
import MealPlanForm from "../MealPlanForm/MealPlanForm";
import Layout from "../../Layout/Layout";
import PageLayout from "../../shared/PageLayout";
import PageTitle from "../../shared/PageTitle";

const AddMealPlan = () => {
  return (
    <Layout>
      <PageLayout>
        <PageTitle title="Create A Meal Plan" />
        <MealPlanForm />
      </PageLayout>
    </Layout>
  );
};

export default AddMealPlan;

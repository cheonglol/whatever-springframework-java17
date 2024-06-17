import { BaseLayout } from "../layouts/BaseLayout";

const LandingView = () => {
  return (
    <BaseLayout
      mainContent={
        <div>
          <h1>
            {"Frontend for "}
            <code>com.cheonglol.whatever-springframework-17</code>
          </h1>
          <hr />
          <strong>Available Endpoints: </strong>
        </div>
      }
    />
  );
};

export default LandingView;

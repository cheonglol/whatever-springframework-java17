import React, { useEffect } from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
// import reportWebVitals from './reportWebVitals';

// ### PRIMEREACT CSS ###
import "primeicons/primeicons.css";
import { PrimeReactProvider } from "primereact/api";
import "primereact/resources/themes/viva-light/theme.css";
import { RouterProvider } from "react-router-dom";
import { router } from "./router/Router";
import LandingView from "./view/LandingView";

const root = ReactDOM.createRoot(document.getElementById("root") as HTMLElement);

interface Props {
  children?: any;
}
const MasterProvider = ({ children }: Props) => {
  useEffect(() => {}, []);

  return (
    <>
      {/* <ReduxStoreProvider store={store}> */}
      <RouterProvider router={router} />
      <PrimeReactProvider>{children}</PrimeReactProvider>
      {/* </ReduxStoreProvider> */}
    </>
  );
};

root.render(
  <React.StrictMode>
    <MasterProvider />
  </React.StrictMode>,
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
// reportWebVitals();

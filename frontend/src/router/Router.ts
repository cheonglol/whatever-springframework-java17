import { RouteObject, createBrowserRouter } from "react-router-dom";
import { ProtectedRoutes } from "./ProtectedRoutes";

import { ErrorView } from "../view/ErrorView";
import App from "../view/LandingView";
import ImageServicePlaygroundView from "../view/ImageServicePlaygroundView";

export const router = createBrowserRouter([
    {
        path: "/",
        Component: App,
        ErrorBoundary: ErrorView
    },
    {
        path: "/image-service-playground",
        Component: ImageServicePlaygroundView
    },
    ...ProtectedRoutes.map((route: RouteObject) => {
        return route;
    }),
]);

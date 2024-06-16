import { RouteObject, createBrowserRouter } from "react-router-dom";
import { ProtectedRoutes } from "./ProtectedRoutes";

import { ErrorView } from "../view/ErrorView";
import ImageServicePlaygroundView from "../view/ImageServicePlaygroundView";
import LandingView from "../view/LandingView";

export const myRouteObjects: RouteObject[] = [
    {
        path: "/",
        Component: LandingView,
        ErrorBoundary: ErrorView,
    },
    {
        path: "/image-service-playground",
        Component: ImageServicePlaygroundView
    },
    ...ProtectedRoutes.map((route: RouteObject) => {
        return route;
    }),
]

export const router = createBrowserRouter(myRouteObjects);

import { memo } from "react";
import { RouteObject, createBrowserRouter } from "react-router-dom";
import { ProtectedRoutes } from "./ProtectedRoutes";

import { ErrorView } from "../view/ErrorView";
import ImageServicePlaygroundView from "../view/ImageServicePlaygroundView";
import LandingView from "../view/LandingView";

// Apply React.memo to your components
const MLandingView = memo(LandingView);
const MImageServicePlaygroundView = memo(ImageServicePlaygroundView);


export const myRouteObjects: RouteObject[] = [
    {
        path: "/",
        Component: MLandingView,
        ErrorBoundary: ErrorView,
    },
    {
        path: "/image-service-playground",
        Component: MImageServicePlaygroundView
    },
    ...ProtectedRoutes.map((route: RouteObject) => {
        return route;
    }),
]

export const router = createBrowserRouter(myRouteObjects);

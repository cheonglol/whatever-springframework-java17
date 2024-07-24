import { memo } from "react";
import { RouteObject, createBrowserRouter } from "react-router-dom";
import { ProtectedRoutes } from "./ProtectedRoutes";

import { ErrorView } from "../view/ErrorView";
import ImageServicePlaygroundView from "../view/ImageServicePlaygroundView";
import LandingView from "../view/LandingView";

// Apply React.memo to your components
const MLandingView = memo(LandingView);
const MImageServicePlaygroundView = memo(ImageServicePlaygroundView);

// TODO: fix how memo is done

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
    {
        path: "/network-protocols-playground",
        Component: MLandingView
    },
    ...ProtectedRoutes.map((route: RouteObject) => {
        return route;
    }),

]

export const router = createBrowserRouter(myRouteObjects);

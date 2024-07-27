import { ToastOptions, TypeOptions } from "react-toastify";

export const STANDARD_TOAST_OPTIONS = (type?: TypeOptions): ToastOptions => {

    return {
        autoClose: 3500,
        closeOnClick: true,
        theme: "light",
        position: "bottom-center",
        type: type ? type : "default"
    }
}
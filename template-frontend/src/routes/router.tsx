import {createBrowserRouter} from 'react-router-dom';
import {Home} from "./Home/home.tsx";
import App from "../App.tsx";

export const router = createBrowserRouter([
    {
        path: "/",
        Component: Home
    },
    {
        path: "/app",
        Component: App
    }
])
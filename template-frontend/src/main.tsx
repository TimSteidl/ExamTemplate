import {createRoot} from 'react-dom/client'
import './index.css'
import {RouterProvider} from "react-router-dom";
import {router} from "./routes/router.tsx";
import {store} from "./redux/reduxStore.ts";
import {Provider} from "react-redux";
import {TemplateContext} from "./context/context.ts";


createRoot(document.getElementById('root')!).render(
    <TemplateContext.Provider value={{templates: [], areTemplatesLoading: false}}>
        <Provider store={store}>
            <RouterProvider router={router}/>
        </Provider>
    </TemplateContext.Provider>
)

import React from "react";
import {Template} from "../types.ts";


export const TemplateContext = React.createContext<TemplateContextType>({
    templates: [],
    areTemplatesLoading: true
});

export type TemplateContextType = {
    templates: Template[]
    areTemplatesLoading: boolean
}
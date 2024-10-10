import {createSlice, PayloadAction} from "@reduxjs/toolkit";
import {useRootSelector} from "./reduxHooks.ts";
import {Template} from "../types.ts";


type TemplateState = {
    templates: Template[]
    areTemplatesLoading: boolean
}

const initialState = {
    templates: [],
    areTemplatesLoading: true
} satisfies TemplateState as TemplateState

const templateSlice = createSlice({
    name: "templates",
    initialState,
    reducers: {
        setTemplates(state, action: PayloadAction<Template[]>) {
            state.templates = action.payload
            state.areTemplatesLoading = false
        },
        invalidateTemplates(state) {
            state.templates = []
            state.areTemplatesLoading = true
        }
    }
})

export const {setTemplates, invalidateTemplates} = templateSlice.actions;
export const templateReducer = templateSlice.reducer;
export const useTemplateReducer = () => useRootSelector(templateSlice.selectSlice);
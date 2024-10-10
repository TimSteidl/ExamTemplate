import {TypedUseSelectorHook, useDispatch, useSelector} from 'react-redux';
import {AppDispatch, RootState} from "./reduxStore.ts";


export const useAppDispatch: () => AppDispatch = useDispatch;
export const useRootSelector: TypedUseSelectorHook<RootState> = useSelector;

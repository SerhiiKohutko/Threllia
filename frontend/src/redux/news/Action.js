import axios from "axios";
import {
    GET_ALL_NEWS_PAGINATED_SUCCESS,
    GET_ALL_NEWS_SUCCESS,
    GET_LATEST_UPDATE_BY_ID_SUCCESS
} from "@/redux/news/ActionType.js";

export const getAllLatestUpdates = () => async (dispatch) => {
    try {
        const response = await axios.get("http://localhost:8080/api/news");
        dispatch({type : GET_ALL_NEWS_SUCCESS, payload : response.data});
    } catch (err){
        console.error(err)
    }
}

export const getAllNewsPaginated = (page) => async (dispatch) => {
    try{
        const response = await axios.get("http://localhost:8080/api/news/paginated", {
            params : {page : page - 1}
        });

        dispatch({type : GET_ALL_NEWS_PAGINATED_SUCCESS, payload : response.data});
    }catch (e) {
        console.error(e)
    }
}

export const getLatestUpdateById = (id) => async (dispatch) => {
    try {
        const response = await axios.get(`http://localhost:8080/api/news/${id}`);

        dispatch({type : GET_LATEST_UPDATE_BY_ID_SUCCESS, payload : response.data});
    }catch (e) {
        console.log(e);
    }
}
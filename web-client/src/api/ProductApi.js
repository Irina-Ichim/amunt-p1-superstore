import fakeData from "../assets/fakeData.json";
import {developmentModeOn} from "./developmentMode.js";

function fakeFetch() {
    console.log("Fetching fake data!");
    return Promise.resolve(fakeData);
}

export class ProductApi {
    getAllProducts() {
        return developmentModeOn ? fakeFetch()

            : fetch("/api/products")
            .then(response => {
                console.log(response.ok)
                if (!response.ok) {
                    throw new Error("Unable to get products. An error occurred");
                }
                return response.json();
            })
    }
}
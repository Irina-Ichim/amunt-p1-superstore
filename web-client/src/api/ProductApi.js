import fakeData from "../assets/fakeProducts.json";
import {developmentModeOn} from "./developmentMode.js";

function fakeFetch() {
    console.log("[development mode] Fetching fake data!");
    return Promise.resolve(fakeData);
}

export class ProductApi {
    getAllProducts() {
        return developmentModeOn ? fakeFetch()

            : fetch("/api/products")
            .then(response => {
                if (!response.ok) {
                    throw new Error("Unable to get products. An error occurred");
                }
                return response.json();
            })
    }
}
import {currentUser, loggedIn} from "../store/session.js";
import {developmentModeOn} from "./developmentMode.js";

function logInUser() {
    loggedIn.update(_ => true);
    currentUser.update(_ => {
        return {
            name: "Pepiño"
        }
    })

}

function fakeLogin() {
    logInUser();
    return Promise.resolve();
}

export class AuthApi {
    login(username, password) {
        return developmentModeOn ? fakeLogin() : fetch("/api/auth/login", {method: 'POST'})
            .then(response => {
                if (!response.ok) {
                    throw new Error("Unable to login");
                }
                logInUser()
            })
    }
}
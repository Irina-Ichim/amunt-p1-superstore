import {currentUser, loggedIn} from "../store/session.js";
import {developmentModeOn} from "./developmentMode.js";

function logInUser(name, id) {
    console.log(name + " " + id);
    loggedIn.update(_ => true);
    currentUser.update(_ => {
        return {
            name,
            id
        }
    })

}

function fakeLogin() {
    logInUser();
    return Promise.resolve();
}

export class AuthApi {
    login(username, password) {
        return developmentModeOn ? fakeLogin() : fetch("/api/auth/login", {
            method: 'POST',
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({username, password})
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error("Unable to login");
                }
                console.log(`response is ${response}`);
                return response.json()
            })
            .then(loginInfo => {
                let {name, id} = loginInfo
                console.log(`name is ${name}`);
                console.log(`id is ${id}`);

                logInUser(name, id);
            })
            .catch(err => console.log(err))
    }
}
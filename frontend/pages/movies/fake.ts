import {Movie} from "./model";

export const fakeMovie: Movie = {
    actors: [{
        id: 0,
        firstName: "Marian",
        lastName: "Kasztan",
        description: "Ziomal",
        birthdate: "Wczoraj",
        height: "194",
        profilePhoto: "https://picsum.photos/200/300"
    },{
        id: 1,
        firstName: "Krzystof",
        lastName: "Sauć",
        description: "Bubel",
        birthdate: "Dzieś",
        height: "194",
        profilePhoto: "https://picsum.photos/200/300"
    }],
    awards: ["Oscar"],
    director: "Mariusz Pietruszka",
    genre: ["Comedy"],
    id: 0,
    moviePhotos: ["https://picsum.photos/200/300", "https://picsum.photos/200/400", "https://picsum.photos/500/300"],
    poster: "https://picsum.photos/250/600",
    premiere: 0,
    production: "USA",
    rating: 8,
    scenario: "Zdzichu",
    title: "Zabili go i uciekł"

}
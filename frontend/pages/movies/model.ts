export interface Actor {
    id: number;
    firstName: string;
    lastName: string;
    description: string;
    birthdate: string;
    height: string;
    profilePhoto: string;
}

export interface Movie {
    id: number;
    title: string;
    rating: number;
    director: string;
    scenario: string;
    genre: string[];
    production: string;
    premiere: number;
    poster: string;
    moviePhotos: string[];
    actors: Actor[];
    awards: string[];
}
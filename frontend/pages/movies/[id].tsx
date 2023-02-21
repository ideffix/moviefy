import {GetServerSideProps} from "next";

interface ServerProps {
  movie: Movie;
}

export interface Actor {
  id: number;
  firstName: string;
  lastName: string;
  description: string;
  birthdate: string;
  height: string;
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

export const getServerSideProps: GetServerSideProps<ServerProps> = async (context) => {
  const movie: Movie = await fetch(`http://localhost:8080/movie/${context.params.id}`).then(res => res.json());

  return {
    props: {
      movie
    }
  }
};

function MoviePage({movie}: ServerProps) {

  return <div><h1>{movie.title}</h1></div>
}

export default MoviePage;

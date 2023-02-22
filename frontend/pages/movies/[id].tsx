import {GetServerSideProps} from "next";
import styles from "./Movies.module.css";
import Gallery from "react-photo-gallery";

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

  return <div className={styles.container}>
    <h1 className={styles.title}>{movie.title}</h1>
    <div className={styles.info}>
      <div className={styles.poster}>
        <img src={movie.poster} alt={'movie poster'}/>
      </div>
      <div className={styles.additionalInfo}>
        <div>
          Here should be some description but this is missing in a backend.
        </div>
        <div className={styles.gridContainer}>
          <div className={styles.firstCol}>Director</div><div>{movie.director}</div>
          <div className={styles.firstCol}>Scenario</div><div>{movie.scenario}</div>
          <div className={styles.firstCol}>Genre</div><div>{movie.genre.map(el => el.toLowerCase().replaceAll("_", " ")).join(', ')}</div>
          <div className={styles.firstCol}>Production</div><div>{movie.production} this is wrong - it should be country like USA</div>
          <div className={styles.firstCol}>Premiere</div><div>{movie.premiere} this is wrong - it should be a date</div>
          <div className={styles.firstCol}>Awards</div><div>{movie.awards.map(el => el.toLowerCase().replaceAll("_", " ")).join(', ')}</div>
        </div>
      </div>
    </div>
    <div>
      <h2>Gallery</h2>
      <Gallery photos={movie.moviePhotos.map(src => ({src , width: 1, height: 1}))} />
    </div>
  </div>
}

export default MoviePage;

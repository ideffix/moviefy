import {GetServerSideProps} from "next";
import styles from "./Movies.module.css";
import Gallery from "react-photo-gallery";
import {Movie} from "./model";
import {fakeMovie} from "./fake";
import Link from "next/link";

interface ServerProps {
    movie: Movie;
}

export const getServerSideProps: GetServerSideProps<ServerProps> = async (context) => {
    const movie: Movie = await fetch(`http://localhost:8080/movie/${context.params.id}`).then(res => res.json());

    return {
        props: {
            movie: fakeMovie
        }
    }
};

function MoviePage({movie}: ServerProps) {
    return <>
        <div className={styles.backgroundImgContainer}>
            <div className={styles.backgroundImg} style={{backgroundImage: `url(${movie.moviePhotos[0]})`}}/>
        </div>
        <div className={styles.container}>
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
                        <div className={styles.firstCol}>Director</div>
                        <div>{movie.director}</div>
                        <div className={styles.firstCol}>Scenario</div>
                        <div>{movie.scenario}</div>
                        <div className={styles.firstCol}>Genre</div>
                        <div>{movie.genre.map(el => el.toLowerCase().replaceAll("_", " ")).join(', ')}</div>
                        <div className={styles.firstCol}>Production</div>
                        <div>{movie.production} this is wrong - it should be country like USA</div>
                        <div className={styles.firstCol}>Premiere</div>
                        <div>{movie.premiere} this is wrong - it should be a date</div>
                        <div className={styles.firstCol}>Awards</div>
                        <div>{movie.awards.map(el => el.toLowerCase().replaceAll("_", " ")).join(', ')}</div>
                    </div>
                </div>
            </div>
            <div>
                <h2>Gallery</h2>
                <Gallery photos={movie.moviePhotos.map(src => ({src, width: 1, height: 1}))}/>
            </div>
            <div>
                <h2>Actors</h2>
                <div className={styles.actors}>
                    {movie.actors.map(actor => <div key={actor.id}>
                        <Link href={`/actors/${actor.id}`}>
                            <img src={actor.profilePhoto} alt={'actor profile photo'}/>
                            <div>{`${actor.firstName} ${actor.lastName}`}</div>
                        </Link>
                    </div>)}
                </div>
            </div>
        </div>
    </>
}

export default MoviePage;

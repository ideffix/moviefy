import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import React from "react";
import styles from "./Header.module.css";
import {faFilm} from '@fortawesome/free-solid-svg-icons'

function SearchInput() {
    return <input type={'text'} placeholder={"Search by movie or actor"}/>;
}

const Header = () => {

    return <div className={styles.container}>
        <div><FontAwesomeIcon icon={faFilm} fontSize={36}/></div>
        <SearchInput />
    </div>
}

export {Header};
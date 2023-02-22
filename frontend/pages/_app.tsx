import { config } from '@fortawesome/fontawesome-svg-core'
import '@fortawesome/fontawesome-svg-core/styles.css'
import {Header} from "../components/Header/Header";
import React from "react";
import "../styles/globals.css"
config.autoAddCss = false

export default function MyApp({ Component, pageProps }) {
    return <><Header /><Component {...pageProps} /></>
}

import {GetServerSideProps} from "next";
import {Header} from "../components/Header/Header";
import React from "react";

interface ServerProps {
  name: string;
  version: string;
}

export const getServerSideProps: GetServerSideProps<ServerProps> = async (context) => {
  const namePromise = fetch("http://localhost:8080/config/name").then(res => res.text());
  const versionPromise = fetch("http://localhost:8080/config/version").then(res => res.text());

  const promises = await Promise.all([namePromise, versionPromise]);

  return {
    props: {
      name: promises[0] as string,
      version: promises[1] as string
    }
  }
};

export default function Home({name, version}: ServerProps) {
  return (
    <>
      <Header />
      <h1>App name: {name}</h1>
      <h2>Version: {version}</h2>
      <style jsx global>{`
        html,
        body {
          padding: 0;
          margin: 0;
          font-family: -apple-system, BlinkMacSystemFont, Segoe UI, Roboto,
            Oxygen, Ubuntu, Cantarell, Fira Sans, Droid Sans, Helvetica Neue,
            sans-serif;
        }
        * {
          box-sizing: border-box;
        }
      `}</style>
    </>
  )
}

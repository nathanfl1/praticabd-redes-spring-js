--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3
-- Dumped by pg_dump version 15.1

-- Started on 2023-10-18 10:06:26

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 214 (class 1259 OID 16538)
-- Name: dispositivo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dispositivo (
    id bigint NOT NULL,
    nome character varying(40),
    mac character varying(17),
    ip character varying(15),
    descricao character varying(100),
    localizacao character varying(50),
    tipo character varying(20)
);


ALTER TABLE public.dispositivo OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16541)
-- Name: dispositivo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.dispositivo ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.dispositivo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


-- Completed on 2023-10-18 10:06:26

--
-- PostgreSQL database dump complete
--


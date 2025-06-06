--
-- PostgreSQL database dump
--

-- Dumped from database version 16.8
-- Dumped by pg_dump version 16.8

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
-- Name: gpslog; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.gpslog (
    id bigint NOT NULL,
    latitude double precision,
    longitude double precision,
    speed double precision,
    speed_violation boolean NOT NULL,
    "timestamp" timestamp(6) without time zone,
    vehicle_id bigint
);


ALTER TABLE public.gpslog OWNER TO postgres;

--
-- Name: gpslog_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.gpslog ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.gpslog_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: t_vehicle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.t_vehicle (
    id bigint NOT NULL,
    name character varying(255),
    plate_number character varying(255) NOT NULL,
    type character varying(255)
);


ALTER TABLE public.t_vehicle OWNER TO postgres;

--
-- Name: t_vehicle_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.t_vehicle ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.t_vehicle_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: gpslog; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.gpslog (id, latitude, longitude, speed, speed_violation, "timestamp", vehicle_id) FROM stdin;
1	-6.2	106.816666	60.5	f	2025-05-07 12:30:00	1
2	-7.2	103.816666	120	t	2025-05-07 12:30:00	2
\.


--
-- Data for Name: t_vehicle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.t_vehicle (id, name, plate_number, type) FROM stdin;
1	Ovanja	F 1234 DN	Family Car
2	Yotoyaw	BK 4321 BM	Family Car
\.


--
-- Name: gpslog_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.gpslog_id_seq', 2, true);


--
-- Name: t_vehicle_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.t_vehicle_id_seq', 2, true);


--
-- Name: gpslog gpslog_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gpslog
    ADD CONSTRAINT gpslog_pkey PRIMARY KEY (id);


--
-- Name: t_vehicle t_vehicle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_vehicle
    ADD CONSTRAINT t_vehicle_pkey PRIMARY KEY (id);


--
-- Name: t_vehicle ukgxb0umpmjvb8c3hxjtblooie3; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.t_vehicle
    ADD CONSTRAINT ukgxb0umpmjvb8c3hxjtblooie3 UNIQUE (plate_number);


--
-- Name: gpslog fkajj09paplp3pv5panqfjxycc8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gpslog
    ADD CONSTRAINT fkajj09paplp3pv5panqfjxycc8 FOREIGN KEY (vehicle_id) REFERENCES public.t_vehicle(id);


--
-- PostgreSQL database dump complete
--


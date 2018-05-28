-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 27, 2018 at 03:23 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `brain-game`
--

-- --------------------------------------------------------

--
-- Table structure for table `comptab`
--

CREATE TABLE `comptab` (
  `username` varchar(200) NOT NULL,
  `focus` varchar(4) DEFAULT NULL,
  `cal` varchar(4) DEFAULT NULL,
  `memory` varchar(4) DEFAULT NULL,
  `work` varchar(20) DEFAULT NULL,
  `outdoor` varchar(10) DEFAULT NULL,
  `indoor` varchar(10) DEFAULT NULL,
  `reading` varchar(10) DEFAULT NULL,
  `writing` varchar(10) DEFAULT NULL,
  `watching` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comptab`
--

INSERT INTO `comptab` (`username`, `focus`, `cal`, `memory`, `work`, `outdoor`, `indoor`, `reading`, `writing`, `watching`) VALUES
('q21', 'no', 'yes', 'yes', 'teacher', NULL, 'indoor', NULL, 'writing', NULL),
('q22', 'no', 'yes', 'no', 'teacher', 'outdoor', NULL, NULL, NULL, 'watching'),
('q23', 'yes', 'no', 'yes', 'banker', NULL, 'indoor', 'reading', NULL, NULL),
('q31', 'yes', 'yes', 'no', 'banker', NULL, NULL, 'reading', NULL, 'watching'),
('q32', 'no', 'yes', 'yes', 'student', 'outdoor', NULL, NULL, 'writing', NULL),
('q41', 'yes', 'no', 'no', 'student', 'outdoor', NULL, NULL, NULL, 'watching'),
('q61', 'yes', 'no', 'no', 'teacher', NULL, NULL, NULL, 'writing', 'watching'),
('q71', 'no', 'yes', 'no', 'banker', 'outdoor', NULL, NULL, 'writing', NULL),
('qwe', 'no', 'no', 'no', 'other', NULL, NULL, NULL, NULL, 'watching'),
('test', 'yes', 'no', 'yes', 'student', 'outdoor', NULL, NULL, NULL, NULL),
('test1', 'no', 'no', 'yes', 'banker', 'outdoor', NULL, 'reading', 'writing', NULL),
('test2', 'yes', 'no', 'no', 'teacher', NULL, NULL, 'reading', NULL, NULL),
('rwq', 'no', 'yes', 'yes', 'student', 'outdoor', NULL, NULL, NULL, NULL),
('wsx', 'no', 'yes', 'no', 'banker', 'outdoor', NULL, 'reading', NULL, NULL),
('qwen', NULL, NULL, NULL, 'student', NULL, NULL, NULL, NULL, NULL),
('qws', 'yes', 'yes', 'no', 'student', 'outdoor', NULL, NULL, NULL, NULL),
('qwsasd', 'yes', 'no', 'no', 'banker', 'outdoor', NULL, 'reading', NULL, NULL),
('shikha', 'yes', 'no', 'yes', 'student', NULL, NULL, 'reading', NULL, NULL),
('qwerty', 'yes', 'no', 'yes', 'banker', NULL, NULL, 'reading', NULL, NULL),
('edc', 'yes', 'no', 'yes', 'student', 'outdoor', NULL, NULL, 'writing', NULL),
('team', 'no', 'yes', 'no', 'student', 'outdoor', NULL, NULL, NULL, NULL),
('team1', 'yes', NULL, 'no', 'student', NULL, NULL, 'reading', NULL, NULL),
('acd', 'yes', 'no', 'yes', 'student', NULL, NULL, 'reading', 'writing', 'watching'),
('qaws', 'no', 'yes', 'no', 'student', 'outdoor', NULL, NULL, 'writing', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `details`
--

CREATE TABLE `details` (
  `name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `birthday` varchar(12) DEFAULT NULL,
  `gender` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `details`
--

INSERT INTO `details` (`name`, `email`, `username`, `password`, `birthday`, `gender`) VALUES
('q21', 'q@q.co', 'q21', 'Qw1234', '2017-01-01', 'female'),
('q22', 'q@w.co', 'q22', 'Qw1234', '2017-01-01', 'male'),
('q23', 'q@w.co', 'q23', 'Qw1234', '2017-01-01', 'rather not say'),
('q31', 'q@w.com', 'q31', 'Qw1234', '2017-01-01', 'male'),
('q32', 'q@w.co', 'q32', 'Qw1234', '2017-01-01', 'male'),
('q41', 'q@w.co', 'q41', 'Qw1234', '2017-01-01', 'female'),
('q61', 'q@w.co', 'q61', 'Qw1234', '2017-01-01', 'female'),
('q71', 'q@w.co', 'q71', 'Qw1234', '2017-01-01', 'rather not say'),
('q', 'q@w.co', 'qwe', 'Qw1234', '2017-01-01', 'male'),
('test', 'q@w.co', 'test', 'Qw1234', '2017-01-01', 'female'),
('test1', 'q@w.co', 'test1', 'Qw1234', '2017-01-01', 'rather not say'),
('test2', 'q@w.com', 'test2', 'Qw1234', '2017-01-01', 'male'),
('r', 'q@q.co', 'rwq', 'Qw1234', '2017-01-01', 'male'),
('w', 'q@w.co', 'wsx', 'Qw1234', '2017-01-01', 'male'),
('qws', 'q@w.co', 'qws', 'Qw1234', '2017-01-01', 'male'),
('qwe', 'q@w.co', 'qwsasd', 'Qw1234', '2017-01-01', 'male'),
('dhruvi', 'dr@gmail.com', 'shikha', '1234Abc', '2017-01-01', 'rather not say'),
('qwerty', 'q@w.co', 'qwerty', 'Qw1234', '2017-01-01', 'female'),
('QWSD', 'q@w.co', 'edc', 'Qw1234', '2017-01-01', 'female'),
('BrainGames Team', 'team@bg.com', 'team', 'Qw1234', '2017-01-01', 'male'),
('asd', 'q@w.co', 'team1', 'Qw1234', '2017-01-01', 'male'),
('Dhruvi', 'abc@xyz.co', 'acd', 'Qwer1234', '1997-01-01', 'female'),
('qaz', 'qwert@y.co', 'qaws', 'Qwerty12', '2017-01-01', 'male');

-- --------------------------------------------------------

--
-- Table structure for table `gamestatus`
--

CREATE TABLE `gamestatus` (
  `username` varchar(200) NOT NULL,
  `probsol` int(3) NOT NULL,
  `memory` int(3) NOT NULL,
  `focus` int(3) NOT NULL,
  `mental` int(3) NOT NULL,
  `sizecount` int(5) NOT NULL,
  `lastcities` int(5) NOT NULL,
  `rushback` int(5) NOT NULL,
  `truecolor` int(5) NOT NULL,
  `rank` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `gamestatus`
--

INSERT INTO `gamestatus` (`username`, `probsol`, `memory`, `focus`, `mental`, `sizecount`, `lastcities`, `rushback`, `truecolor`, `rank`) VALUES
('q21', 81, 81, 81, 81, 0, 0, 0, 0, 1),
('q22', 81, 81, 81, 81, 0, 0, 0, 0, 2),
('q23', 81, 81, 81, 81, 0, 0, 0, 0, 2),
('q31', 100, 55, 81, 37, 0, 0, 0, 0, 3),
('q32', 100, 55, 81, 37, 0, 0, 0, 0, 3),
('q41', 37, 81, 100, 55, 0, 0, 0, 0, 4),
('q61', 55, 100, 37, 81, 0, 0, 0, 0, 6),
('q71', 81, 37, 55, 100, 0, 0, 0, 0, 7),
('qwe', 25, 25, 25, 25, 0, 0, 0, 0, 5),
('test1', 81, 81, 81, 81, 0, 0, 0, 0, 2),
('test2', 81, 81, 81, 81, 0, 0, 0, 0, 2),
('rwq', 100, 55, 81, 37, 0, 0, 0, 0, 3),
('wsx', 100, 55, 81, 37, 0, 0, 0, 1850, 3),
('qws', 100, 55, 81, 37, 2000, 0, 0, 0, 3),
('qwsasd', 100, 55, 81, 37, 2000, 150, 0, 0, 3),
('shikha', 25, 25, 25, 25, 1550, 0, 3350, 1850, 5),
('qwerty', 25, 25, 25, 25, 950, 0, 0, 0, 5),
('edc', 25, 25, 25, 25, 800, 0, 3200, 0, 5),
('team', 100, 100, 100, 100, 2000, 0, 3050, 0, 1),
('team1', 25, 25, 25, 25, 200, 0, 0, 0, 5),
('acd', 25, 25, 25, 25, 1850, 1250, 0, 0, 5),
('qaws', 25, 25, 25, 25, 300, 0, 0, 0, 5);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

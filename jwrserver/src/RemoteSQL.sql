-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 10, 2022 at 01:20 AM
-- Server version: 8.0.13-4
-- PHP Version: 7.2.24-0ubuntu0.18.04.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Ee1ZADuysl`
--

-- --------------------------------------------------------

--
-- Table structure for table `Customer`
--

CREATE TABLE `Customer` (
  `customerID` varchar(100) NOT NULL,
  `name` varchar(50) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(50) NOT NULL,
  `telephone` bigint(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `dateOfMembership` date NOT NULL,
  `dateOfMembershipExpiry` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Customer`
--

INSERT INTO `Customer` (`customerID`, `name`, `dob`, `address`, `telephone`, `email`, `dateOfMembership`, `dateOfMembershipExpiry`) VALUES
('1', 'Anthony Miller', '2003-06-23', 'Hannings Road', 8761234536, 'AnthonyTest1@gmail.com', '2022-10-19', '2026-10-19'),
('2', 'Anthony Miller', '2003-06-23', 'Hannings Road', 8761234536, 'Anthony1@gmail.com', '2022-10-16', '2026-10-16'),
('5afad0cb-084e-44a5-8b1a-5c3c6a0766d9', 'Fred Miller', '2000-10-15', 'Manor Park', 87612355126, 'Test1@gmail.com', '2022-11-09', '2026-11-09');


-- --------------------------------------------------------

--
-- Table structure for table `Department`
--

CREATE TABLE `Department` (
  `departmentCode` varchar(5) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Department`
--

INSERT INTO `Department` (`departmentCode`, `name`) VALUES
('200', 'Management');

-- --------------------------------------------------------

--
-- Table structure for table `Inventory`
--

CREATE TABLE `Inventory` (
  `productCode` varchar(100) NOT NULL,
  `name` varchar(50) NOT NULL,
  `itemsInStock` int(11) NOT NULL,
  `unitPrice` int(11) NOT NULL,
  `shortDescription` varchar(100) NOT NULL,
  `longDescription` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Inventory`
--

INSERT INTO `Inventory` (`productCode`, `name`, `itemsInStock`, `unitPrice`, `shortDescription`, `longDescription`) VALUES
('3465e6a3-860a-4584-96af-58cabfc3b186', 'Pepsi', 200, 50, 'Pepsi Drink', 'A drink named pepsi');

-- --------------------------------------------------------

--
-- Table structure for table `Invoice`
--

CREATE TABLE `Invoice` (
  `invoiceNum` int(11) NOT NULL,
  `billingDate` date NOT NULL,
  `cashier` varchar(100) NOT NULL,
  `customer` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `InvoiceItem`
--

CREATE TABLE `InvoiceItem` (
  `productCode` varchar(100) NOT NULL,
  `invoiceNum` int(11) NOT NULL,
  `quantityOfItem` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Staff`
--

CREATE TABLE `Staff` (
  `staffID` varchar(100) NOT NULL,
  `name` varchar(50) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(50) NOT NULL,
  `telephone` bigint(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `type` varchar(20) NOT NULL,
  `department` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Staff`
--

INSERT INTO `Staff` (`staffID`, `name`, `dob`, `address`, `telephone`, `email`, `type`, `department`) VALUES
('cc7ffc1a-b1d5-4145-9d3f-d1e19fbe2bf8', 'Alesha Ronbinson', '1990-02-16', '2 Kings Street', 8766932165, 'Alesha@gmail.com', 'Manager', '200');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Customer`
--
ALTER TABLE `Customer`
  ADD PRIMARY KEY (`customerID`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `Department`
--
ALTER TABLE `Department`
  ADD PRIMARY KEY (`departmentCode`);

--
-- Indexes for table `Inventory`
--
ALTER TABLE `Inventory`
  ADD PRIMARY KEY (`productCode`);

--
-- Indexes for table `Invoice`
--
ALTER TABLE `Invoice`
  ADD PRIMARY KEY (`invoiceNum`),
  ADD KEY `invoiceCashier` (`cashier`),
  ADD KEY `invoiceCustomer` (`customer`);

--
-- Indexes for table `InvoiceItem`
--
ALTER TABLE `InvoiceItem`
  ADD PRIMARY KEY (`productCode`,`invoiceNum`),
  ADD KEY `invoice` (`invoiceNum`);

--
-- Indexes for table `Staff`
--
ALTER TABLE `Staff`
  ADD PRIMARY KEY (`staffID`),
  ADD KEY `departmentStaff` (`department`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Invoice`
--
ALTER TABLE `Invoice`
  MODIFY `invoiceNum` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Invoice`
--
ALTER TABLE `Invoice`
  ADD CONSTRAINT `FKCustomer` FOREIGN KEY (`customer`) REFERENCES `Customer` (`customerid`),
  ADD CONSTRAINT `FKStaff` FOREIGN KEY (`cashier`) REFERENCES `Staff` (`staffid`);

--
-- Constraints for table `InvoiceItem`
--
ALTER TABLE `InvoiceItem`
  ADD CONSTRAINT `FKInventory` FOREIGN KEY (`productCode`) REFERENCES `Inventory` (`productcode`),
  ADD CONSTRAINT `FKInvoice` FOREIGN KEY (`invoiceNum`) REFERENCES `Invoice` (`invoicenum`);

--
-- Constraints for table `Staff`
--
ALTER TABLE `Staff`
  ADD CONSTRAINT `departmentStaff` FOREIGN KEY (`department`) REFERENCES `Department` (`departmentcode`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

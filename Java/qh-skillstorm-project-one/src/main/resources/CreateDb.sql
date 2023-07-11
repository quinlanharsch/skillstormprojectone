/*******************************************************************************
   Chinook Database - Version 1.0
   Script: CreateDb.sql
   Description: Creates and populates the FreeHouse database.
   DB Server: PostgreSql
   Author: Quinlan Harsch
********************************************************************************/

/*******************************************************************************
   Create Database
********************************************************************************/
CREATE DATABASE "FreeHousePrd"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
SET TIMEZONE='America/New_York';

/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE Warehouses
(
    WhsId SERIAL PRIMARY KEY,
    Name VARCHAR(120) NOT NULL,
    Capacity NUMERIC(12,0) NOT NULL,
    ClimateControlled BOOLEAN,
    Manager VARCHAR(64),
    Street1 VARCHAR(40),
    Street2 VARCHAR(40),
    City VARCHAR(20),
    State CHAR(2),
    Zip CHAR(5),
    Country CHAR(3),
    UserLogged VARCHAR(64) NOT NULL,
    CallTime TIMESTAMP NOT NULL
);

CREATE TABLE ObjTypes
(
    TypId SERIAL PRIMARY KEY,
    Name VARCHAR(120) NOT NULL,
    Description VARCHAR(1200),
    Size NUMERIC(12,0) NOT NULL,
    UserLogged VARCHAR(64) NOT NULL,
    CallTime TIMESTAMP NOT NULL
);

CREATE TABLE WhsObjects
(
    WhsId INT NOT NULL,
    TypId INT NOT NULL,
    Quantity INT NOT NULL,
    Note VARCHAR(1200),
    UserLogged VARCHAR(64) NOT NULL,
    CallTime TIMESTAMP NOT NULL,
    PRIMARY KEY (WhsId, TypId)
);

-- POSSIBLE IMPROVEMENTS
-- Obj Groups

/*******************************************************************************
   Create Primary Key Unique Indexes
********************************************************************************/

/*******************************************************************************
   Create Foreign Keys
********************************************************************************/
ALTER TABLE WhsObjects ADD CONSTRAINT FK_WhsId
    FOREIGN KEY (WhsId) REFERENCES Warehouses (WhsId) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE WhsObjects ADD CONSTRAINT FK_TypId
    FOREIGN KEY (TypId) REFERENCES ObjTypes (TypId) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*******************************************************************************
   Populate Tables (Optional)
   Dummy data from ChatGPT
********************************************************************************/

/* Warehouses */
INSERT INTO Warehouses (Name, Capacity, ClimateControlled, Manager, Street1, Street2, City, State, Zip, Country, UserLogged, CallTime)
VALUES ('Panacea', 100000, true, 'JohnDoe', '123 Main St', '', 'New York City', 'NY', '10001', 'USA', 'system', NOW());
INSERT INTO Warehouses (Name, Capacity, ClimateControlled, Manager, Street1, Street2, City, State, Zip, Country, UserLogged, CallTime)
VALUES ('Hygieia', 150000, true, 'JaneSmith', '456 Elm St', '', 'Los Angeles', 'CA', '90001', 'USA', 'system', NOW());
INSERT INTO Warehouses (Name, Capacity, ClimateControlled, Manager, Street1, Street2, City, State, Zip, Country, UserLogged, CallTime)
VALUES ('Apollo', 200000, false, 'JaneSmith', '789 Oak St', '', 'Los Angeles', 'CA', '90001', 'USA', 'system', NOW());
INSERT INTO Warehouses (Name, Capacity, ClimateControlled, Manager, Street1, Street2, City, State, Zip, Country, UserLogged, CallTime)
VALUES ('Iaso', 120000, false, 'EmilyDavis', '321 Pine St', '', 'Houston', 'TX', '77001', 'USA', 'system', NOW());
INSERT INTO Warehouses (Name, Capacity, ClimateControlled, Manager, Street1, Street2, City, State, Zip, Country, UserLogged, CallTime)
VALUES ('Epione', 180000, true, 'MichaelBrown', '654 Cedar St', '', 'Miami', 'FL', '33101', 'USA', 'system', NOW());
--Asclepius

/* ObjectTypes */
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Medical Gloves', 'Disposable gloves worn by healthcare providers to protect against contamination and infection.', 10, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Adhesive Bandages', 'Sterile adhesive strips used to cover small wounds and cuts.', 10, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Gauze Pads', 'Sterile pads made of cotton or other materials used to dress wounds and control bleeding.', 10, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Adhesive Tape', 'Rolls of tape used for securing bandages and dressings in place.', 10, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Burn Dressings', 'Specialized dressings used for the treatment of burns to protect the wound and promote healing.', 10, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Defibrillator', 'Portable electronic device used to restore normal heart rhythm in patients experiencing cardiac arrest.', 10, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Ventilator', 'Assists with breathing by delivering oxygen to the lungs and removing carbon dioxide from the body.', 20, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Sphygmomanometer', 'Measures blood pressure by using an inflatable cuff placed around the upper arm.', 10, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Stethoscope', 'Medical device used to listen to internal sounds of the body, such as the heart and lungs.', 10, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Oxygen Cylinder', 'Container that holds compressed oxygen for administration to patients with respiratory conditions.', 30, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Nebulizer', 'Device that converts liquid medication into a fine mist, which can be inhaled through a mask or mouthpiece.', 10, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Splint', 'Orthopedic device used to immobilize and support a fractured or injured limb.', 20, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Tourniquet', 'Applies pressure to a limb to control bleeding by restricting blood flow.', 10, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Spine Board', 'Rigid board used to immobilize and transport patients with suspected spinal injuries.', 30, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('CPR Mask', 'Transparent mask used to administer cardiopulmonary resuscitation (CPR) with a barrier between the rescuer and the patient.', 10, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Glucometer', 'Device used to measure blood glucose levels for monitoring diabetes.', 10, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Backboard', 'Sturdy, long board used to immobilize and transport patients with suspected spinal injuries.', 30, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Traction Splint', 'Splint used to stabilize and align fractures of the femur (thigh bone).', 20, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Gurney', 'Portable bed with wheels used to transport patients within a medical facility.', 30, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Airway Adjuncts', 'Devices used to maintain an open airway and assist with ventilation.', 10, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Suction Unit', 'Device used to remove mucus, blood, and other fluids from a patient''s airway.', 20, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('AED (Automated External Defibrillator)', 'Portable device that automatically analyzes heart rhythms and delivers electric shocks to restore normal rhythm.', 20, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Pulse Oximeter', 'Measures the oxygen saturation level and pulse rate of a patient''s blood.', 10, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('IV Catheter', 'Hollow, flexible tube inserted into a vein to administer fluids, medications, or obtain blood samples.', 10, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Splinting Materials', 'Various materials (e.g., padded boards, rolls, and wraps) used for splinting fractured or injured limbs.', 30, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Bandages', 'Various types of sterile dressings used to cover wounds and control bleeding.', 10, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Cervical Collar', 'Supportive device used to immobilize the neck and spine in patients with suspected cervical spine injuries.', 10, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Oxygen Mask', 'Device used to deliver oxygen to a patient''s respiratory system through the nose and mouth.', 10, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('CPR Pocket Mask', 'A compact mask with a one-way valve used during CPR to provide a barrier between the rescuer and the patient.', 10, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Triangular Bandages', 'Large, triangular pieces of cloth used for making slings, immobilizing limbs, and creating bandages.', 20, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Tweezers', 'Small handheld tools with pointed tips used for removing splinters or foreign objects from the skin.', 10, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Antiseptic Solution', 'Liquid solutions containing antiseptic agents used to clean wounds and prevent infection.', 10, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Instant Cold Packs', 'Single-use packs that provide instant cold therapy to reduce swelling and relieve pain.', 10, 'system', NOW());
INSERT INTO ObjTypes (Name, Description, Size, UserLogged, CallTime)
VALUES ('Medical Scissors', 'Sharp, curved scissors used for cutting bandages, clothing, and other materials in medical emergencies.', 10, 'system', NOW());

/* WhsObjects */
-- Warehouse P
INSERT INTO WhsObjects (WhsId, TypId, Quantity, Note, UserLogged, CallTime)
VALUES (1, 1, 10, 'Donation', 'system', NOW());
INSERT INTO WhsObjects (WhsId, TypId, Quantity, UserLogged, CallTime)
VALUES (1, 2, 10, 'system', NOW());
INSERT INTO WhsObjects (WhsId, TypId, Quantity, UserLogged, CallTime)
VALUES (1, 3, 10, 'system', NOW());
INSERT INTO WhsObjects (WhsId, TypId, Quantity, UserLogged, CallTime)
VALUES (1, 4, 10, 'system', NOW());
INSERT INTO WhsObjects (WhsId, TypId, Quantity, UserLogged, CallTime)
VALUES (1, 5, 10, 'system', NOW());
-- Warehouse H
INSERT INTO WhsObjects (WhsId, TypId, Quantity, UserLogged, CallTime)
VALUES (2, 1, 10, 'system', NOW());
INSERT INTO WhsObjects (WhsId, TypId, Quantity, UserLogged, CallTime)
VALUES (2, 2, 10, 'system', NOW());
INSERT INTO WhsObjects (WhsId, TypId, Quantity, UserLogged, CallTime)
VALUES (2, 3, 10, 'system', NOW());
INSERT INTO WhsObjects (WhsId, TypId, Quantity, UserLogged, CallTime)
VALUES (2, 4, 10, 'system', NOW());
INSERT INTO WhsObjects (WhsId, TypId, Quantity,Note, UserLogged, CallTime)
VALUES (2, 5, 10, 'Donation', 'system', NOW());
-- Warehouse A
INSERT INTO WhsObjects (WhsId, TypId, Quantity, UserLogged, CallTime)
VALUES (3, 1, 10, 'system', NOW());
INSERT INTO WhsObjects (WhsId, TypId, Quantity, UserLogged, CallTime)
VALUES (3, 2, 10, 'system', NOW());
INSERT INTO WhsObjects (WhsId, TypId, Quantity, UserLogged, CallTime)
VALUES (3, 3, 10, 'system', NOW());
INSERT INTO WhsObjects (WhsId, TypId, Quantity,Note, UserLogged, CallTime)
VALUES (3, 4, 10, 'Donation', 'system', NOW());
INSERT INTO WhsObjects (WhsId, TypId, Quantity, UserLogged, CallTime)
VALUES (3, 5, 10, 'system', NOW());
-- Warehouse I
INSERT INTO WhsObjects (WhsId, TypId, Quantity, UserLogged, CallTime)
VALUES (4, 1, 10, 'system', NOW());
INSERT INTO WhsObjects (WhsId, TypId, Quantity,Note, UserLogged, CallTime)
VALUES (4, 2, 10, 'Donation', 'system', NOW());
INSERT INTO WhsObjects (WhsId, TypId, Quantity, UserLogged, CallTime)
VALUES (4, 3, 10, 'system', NOW());
INSERT INTO WhsObjects (WhsId, TypId, Quantity, UserLogged, CallTime)
VALUES (4, 4, 10, 'system', NOW());
INSERT INTO WhsObjects (WhsId, TypId, Quantity, UserLogged, CallTime)
VALUES (4, 5, 10, 'system', NOW());
-- Warehouse E
INSERT INTO WhsObjects (WhsId, TypId, Quantity, UserLogged, CallTime)
VALUES (5, 1, 10, 'system', NOW());
INSERT INTO WhsObjects (WhsId, TypId, Quantity, UserLogged, CallTime)
VALUES (5, 2, 10, 'system', NOW());
INSERT INTO WhsObjects (WhsId, TypId, Quantity,Note, UserLogged, CallTime)
VALUES (5, 3, 10, 'Found in trash', 'system', NOW());
INSERT INTO WhsObjects (WhsId, TypId, Quantity, UserLogged, CallTime)
VALUES (5, 4, 10, 'system', NOW());
INSERT INTO WhsObjects (WhsId, TypId, Quantity, UserLogged, CallTime)
VALUES (5, 5, 10, 'system', NOW());

-- SOON could add expiration date to WhsObj

------------------
-- TODO DELETE vvv
/*******************************************************************************
   Create Sprocs (to decouple)
********************************************************************************/
-- CREATE PROCEDURE DelWarehouseById(WarehouseId int)
-- LANGUAGE SQL
-- BEGIN ATOMIC
--     IF WarehouseId != 1 THEN
--         DELETE FROM WhsObjects o where o.WhsId = WarehouseId;
--         DELETE FROM Warehouses w WHERE w.WhsId = WarehouseId;
--     END IF;
-- END;

-- CREATE PROCEDURE DelWhsObjectById(Whsid int, Typid int)
-- LANGUAGE SQL
-- BEGIN ATOMIC
--     DELETE FROM WhsObjects o where o.wHSID = Whsid AND o.TypId = Typid;
-- END;

-- CREATE PROCEDURE DelTypeById(TypeId int)
-- LANGUAGE SQL
-- BEGIN ATOMIC
--     DELETE FROM WhsObjects o where o.TypId = TypeId;
--     DELETE FROM ObjTypes t WHERE t.TypId = TypeId;
-- END;

-- CREATE PROCEDURE AddType(WarehouseName varchar(120), WarehouseCapacity int, User varchar(120))
-- LANGUAGE SQL
-- BEGIN ATOMIC
--     INSERT INTO Warehouses (WhsName, WhsCapacity, UserLogged, CallTime) VALUES (WarehouseName, WarehouseCapacity, User, NOW());
-- END;

-- CREATE PROCEDURE AddWarehouse(TypeName VARCHAR(120), TypeDescription VARCHAR(1200), TypeSize NUMERIC(12,0), User varchar(120))
-- LANGUAGE SQL
-- BEGIN ATOMIC
--     INSERT INTO ObjTypes (TypName, TypDesc, TypSize, UserLogged, CallTime) VALUES (TypeName, TypeDescription, TypeSize, User, NOW());    
-- END;

CREATE PROCEDURE WhsCapacityLeft(WarehouseId INT)
LANGUAGE SQL
BEGIN ATOMIC
    SELECT MAX(w.capacity) - SUM(t.size * o.quantity) CapSum
    -- TODO * QUANTITY
    FROM public.Warehouses w
    JOIN public.WhsObjects o ON w.WhsId = o.WhsId
    JOIN public.ObjTypes t on t.TypId = o.TypId
    WHERE w.WhsId = 1 --WarehouseId
    ;
END;

-- TODO ADD/DEL Type
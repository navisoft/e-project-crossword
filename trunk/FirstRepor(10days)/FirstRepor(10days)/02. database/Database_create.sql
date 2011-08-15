/* ---------------------------------------------------------------------- */
/* Script generated with: DeZign for Databases v4.1.3                     */
/* Target DBMS:           MS SQL Server 2005                              */
/* Project file:          Puzzle.dez                                      */
/* Project name:                                                          */
/* Author:                                                                */
/* Script type:           Database creation script                        */
/* Created on:            2011-08-06 23:20                                */
/* ---------------------------------------------------------------------- */


/* ---------------------------------------------------------------------- */
/* Tables                                                                 */
/* ---------------------------------------------------------------------- */

/* ---------------------------------------------------------------------- */
/* Add table "puzzle"                                                     */
/* ---------------------------------------------------------------------- */

CREATE TABLE [puzzle] (
    [id] INTEGER IDENTITY(1,1) NOT NULL,
    [name] NVARCHAR(40) NOT NULL,
    CONSTRAINT [PK_puzzle] PRIMARY KEY ([id])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "users"                                                      */
/* ---------------------------------------------------------------------- */

CREATE TABLE [users] (
    [id] INTEGER IDENTITY(1,1) NOT NULL,
    [username] VARCHAR(40) NOT NULL,
    [password] VARCHAR(40) NOT NULL,
    CONSTRAINT [PK_users] PRIMARY KEY ([id])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "question"                                                   */
/* ---------------------------------------------------------------------- */

CREATE TABLE [question] (
    [id] INTEGER IDENTITY(1,1) NOT NULL,
    [detail] NVARCHAR(300),
    CONSTRAINT [PK_question] PRIMARY KEY ([id])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "answer4x4"                                                  */
/* ---------------------------------------------------------------------- */

CREATE TABLE [answer4x4] (
    [id] INTEGER IDENTITY(1,1) NOT NULL,
    [puzzleid] INTEGER NOT NULL,
    [questionid] INTEGER NOT NULL,
    [value1] VARCHAR(1) NOT NULL,
    [value2] VARCHAR(1) NOT NULL,
    [value3] VARCHAR(1) NOT NULL,
    [value4] VARCHAR(1) NOT NULL,
    CONSTRAINT [PK_answer4x4] PRIMARY KEY ([id])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "answer6x6"                                                  */
/* ---------------------------------------------------------------------- */

CREATE TABLE [answer6x6] (
    [id] INTEGER IDENTITY(1,1) NOT NULL,
    [puzzleid] INTEGER NOT NULL,
    [questionid] INTEGER,
    [value1] VARCHAR(1) NOT NULL,
    [value2] VARCHAR(1) NOT NULL,
    [value3] VARCHAR(1) NOT NULL,
    [value4] VARCHAR(1) NOT NULL,
    [value5] VARCHAR(1) NOT NULL,
    [value6] VARCHAR(1) NOT NULL,
    CONSTRAINT [PK_answer6x6] PRIMARY KEY ([id])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "hightscore"                                                 */
/* ---------------------------------------------------------------------- */

CREATE TABLE [hightscore] (
    [id] INTEGER IDENTITY(1,1) NOT NULL,
    [playername] VARCHAR(40) NOT NULL,
    [puzzleid] INTEGER NOT NULL,
    CONSTRAINT [PK_hightscore] PRIMARY KEY ([id])
)
GO

/* ---------------------------------------------------------------------- */
/* Foreign key constraints                                                */
/* ---------------------------------------------------------------------- */

ALTER TABLE [answer4x4] ADD CONSTRAINT [question_answer4x4] 
    FOREIGN KEY ([questionid]) REFERENCES [question] ([id])
GO

ALTER TABLE [answer6x6] ADD CONSTRAINT [question_answer6x6] 
    FOREIGN KEY ([questionid]) REFERENCES [question] ([id])
GO

ALTER TABLE [answer6x6] ADD CONSTRAINT [puzzle_answer6x6] 
    FOREIGN KEY ([puzzleid]) REFERENCES [puzzle] ([id])
GO

ALTER TABLE [hightscore] ADD CONSTRAINT [answer4x4_hightscore] 
    FOREIGN KEY ([puzzleid]) REFERENCES [answer4x4] ([puzzleid])
GO

ALTER TABLE [hightscore] ADD CONSTRAINT [answer6x6_hightscore] 
    FOREIGN KEY ([puzzleid]) REFERENCES [answer6x6] ([puzzleid])
GO

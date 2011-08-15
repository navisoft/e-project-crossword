/* ---------------------------------------------------------------------- */
/* Script generated with: DeZign for Databases v4.1.3                     */
/* Target DBMS:           MS SQL Server 2005                              */
/* Project file:          Puzzle.dez                                      */
/* Project name:                                                          */
/* Author:                                                                */
/* Script type:           Database drop script                            */
/* Created on:            2011-08-06 23:20                                */
/* ---------------------------------------------------------------------- */


/* ---------------------------------------------------------------------- */
/* Drop foreign key constraints                                           */
/* ---------------------------------------------------------------------- */

ALTER TABLE [answer4x4] DROP CONSTRAINT [question_answer4x4]
GO

ALTER TABLE [answer6x6] DROP CONSTRAINT [question_answer6x6]
GO

ALTER TABLE [answer6x6] DROP CONSTRAINT [puzzle_answer6x6]
GO

ALTER TABLE [hightscore] DROP CONSTRAINT [answer4x4_hightscore]
GO

ALTER TABLE [hightscore] DROP CONSTRAINT [answer6x6_hightscore]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "puzzle"                                                    */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [puzzle] DROP CONSTRAINT [PK_puzzle]
GO

/* Drop table */

DROP TABLE [puzzle]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "users"                                                     */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [users] DROP CONSTRAINT [PK_users]
GO

/* Drop table */

DROP TABLE [users]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "question"                                                  */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [question] DROP CONSTRAINT [PK_question]
GO

/* Drop table */

DROP TABLE [question]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "answer4x4"                                                 */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [answer4x4] DROP CONSTRAINT [PK_answer4x4]
GO

/* Drop table */

DROP TABLE [answer4x4]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "answer6x6"                                                 */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [answer6x6] DROP CONSTRAINT [PK_answer6x6]
GO

/* Drop table */

DROP TABLE [answer6x6]
GO

/* ---------------------------------------------------------------------- */
/* Drop table "hightscore"                                                */
/* ---------------------------------------------------------------------- */

/* Drop constraints */

ALTER TABLE [hightscore] DROP CONSTRAINT [PK_hightscore]
GO

/* Drop table */

DROP TABLE [hightscore]
GO

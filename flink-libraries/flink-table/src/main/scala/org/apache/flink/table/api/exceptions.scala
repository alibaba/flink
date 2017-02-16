/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.table.api

/**
  * Exception for all errors occurring during expression parsing.
  */
case class ExpressionParserException(msg: String) extends RuntimeException(msg)

/**
  * Exception for all errors occurring during sql parsing.
  */
case class SqlParserException(
    msg: String,
    cause: Throwable)
  extends RuntimeException(msg, cause) {

  def this(msg: String) = this(msg, null)

}

/**
  * General Exception for all errors during table handling.
  */
case class TableException(
    msg: String,
    cause: Throwable)
  extends RuntimeException(msg, cause) {

  def this(msg: String) = this(msg, null)

}

object TableException {
  def apply(msg: String): TableException = new TableException(msg)
}

/**
  * Exception for all errors occurring during validation phase.
  */
case class ValidationException(
    msg: String,
    cause: Throwable)
  extends RuntimeException(msg, cause) {

  def this(msg: String) = this(msg, null)

}

object ValidationException {
  def apply(msg: String): ValidationException = new ValidationException(msg)
}

/**
  * Exception for unwanted method calling on unresolved expression.
  */
case class UnresolvedException(msg: String) extends RuntimeException(msg)

/**
  * Exception for operation on a nonexistent table
  *
  * @param tableIdentifier table identifier
  * @param cause
  */
case class TableNotExistException(
    tableIdentifier: String,
    cause: Throwable)
    extends RuntimeException(s"table ${tableIdentifier} does not exist!", cause) {

  def this(tableIdentifier: String) = this(tableIdentifier, null)

}

/**
  * Exception for adding an already existed table
  *
  * @param tableIdentifier table identifier
  * @param cause
  */
case class TableAlreadyExistException(
    tableIdentifier: String,
    cause: Throwable)
    extends RuntimeException(s"table ${tableIdentifier} already exists!", cause) {

  def this(tableIdentifier: String) = this(tableIdentifier, null)

}

/**
  * Exception for operation on a nonexistent database
  *
  * @param databaseIdentifier database identifier
  * @param cause
  */
case class DatabaseNotExistException(
    databaseIdentifier: String,
    cause: Throwable)
    extends RuntimeException(s"database ${databaseIdentifier} does not exist!", cause) {

  def this(databaseIdentifier: String) = this(databaseIdentifier, null)
}

/**
  * Exception for adding an already existed database
  *
  * @param databaseIdentifier database identifier
  * @param cause
  */
case class DatabaseAlreadyExistException(
    databaseIdentifier: String,
    cause: Throwable)
    extends RuntimeException(s"database ${databaseIdentifier} already exists!", cause) {

  def this(databaseIdentifier: String) = this(databaseIdentifier, null)
}

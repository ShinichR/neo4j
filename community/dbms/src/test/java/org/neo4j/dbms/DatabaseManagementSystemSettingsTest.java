/*
 * Copyright (c) 2002-2017 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.dbms;

import java.io.File;

import org.junit.Test;

import org.neo4j.kernel.configuration.Config;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

import static org.neo4j.helpers.collection.MapUtil.stringMap;

public class DatabaseManagementSystemSettingsTest
{
    @Test
    public void shouldPutDatabaseDirectoriesIntoDataDatabases()
    {
        Config config = new Config( stringMap( DatabaseManagementSystemSettings.data_directory.name(), "the-data-directory" ) );
        assertThat( config.get( DatabaseManagementSystemSettings.database_path ),
                equalTo( new File( "the-data-directory/databases/graph.db" ) ) );
    }
}

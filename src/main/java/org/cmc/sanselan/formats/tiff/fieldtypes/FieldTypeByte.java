/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cmc.sanselan.formats.tiff.fieldtypes;

import org.cmc.sanselan.formats.tiff.TiffField;

public class FieldTypeByte extends FieldType
{
	public FieldTypeByte(int type, String name)
	{
		super(type, 1, name);
	}

	public Object getSimpleValue(TiffField entry)
	{
		if (entry.length == 1)
			return new Byte(entry.valueOffsetBytes[0]);

		return getRawBytes(entry);
	}

	public byte[] writeData(Object o, int byteOrder)
	{
		if (o instanceof Byte)
			return new byte[]{
				((Byte) o).byteValue(),
			};

		return (byte[]) o;
	}
}
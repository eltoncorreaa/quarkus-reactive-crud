/**
 * @author Elton Cesar Rufino Correa - eltonrufino@hotmail.com
 * @linkedin https://www.linkedin.com/in/elton-correa/
 * @date 20 Jul 2022
 * @version 1
 */
package com.elton.reactive.cross;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public final class ZonedDateFactory {

	public static final String BR = "+03:00";

	public static ZonedDateTime now(final String zone){
		return ZonedDateTime.now( ZoneId.of("GMT".concat(of(zone))));
	}

	private static String of(final String zone) {
		var z = new String();

		switch (zone){
		case "BR" :
			z = BR;
			break;
		}
		return z;
	}
}
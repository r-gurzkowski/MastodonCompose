/*
 * This file is part of MastodonX.
 *
 * MastodonX is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * MastodonX is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with MastodonX. If not, see <https://www.gnu.org/licenses/>.
 */
package social.androiddev.common.network.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.URLProtocol
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import social.androiddev.common.network.MastodonApi
import social.androiddev.common.network.MastodonApiKtor

/**
 * Koin module containing all koin/bean definitions for
 * network/api related classes
 */
val networkModule: Module = module {

    singleOf<HttpClient> {
        HttpClient {
            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                }
            }
        }
    }

    single<MastodonApi> {
        MastodonApiKtor(
            httpClient = get(),
        )
    }
}

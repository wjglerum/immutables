/*
 * Copyright 2019 Immutables Authors and Contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.immutables.criteria.repository;

import org.reactivestreams.Publisher;

/**
 * Repository based on <a href="https://www.reactive-streams.org/">Reactive Streams</a>.
 * All final operations will return {@link Publisher}.
 *
 * @param <T> entity type
 * @see Publisher
 */
public interface ReactiveRepository<T> extends Repository<T> {

  interface Reader<T> extends Repository.Reader<T, Reader<T>> {

    Publisher<T> fetch();

  }

  interface Readable<T> extends ReactiveRepository<T>, Repository.Readable<T, ReactiveRepository.Reader<T>> {

  }

  interface Writable<T> extends ReactiveRepository<T>, Repository.Writable<T, Publisher<WriteResult>> {

  }

}
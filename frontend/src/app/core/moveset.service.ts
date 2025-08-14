import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StrictHttpResponse } from '../../apiModels/strict-http-response';
import { MoveListResponse } from '../../apiModels/models';
import { postMoveSearch } from '../../apiModels/fn/move/post-move-search';

@Injectable({
  providedIn: 'root'
})
export class MovesetService {
  private rootUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  searchMoves(moveNames: string[] | undefined): Observable<StrictHttpResponse<MoveListResponse>> {
    console.log(moveNames);
    return postMoveSearch(this.http, this.rootUrl, { body: { names: moveNames } })
  }
  
}

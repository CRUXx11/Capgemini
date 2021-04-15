import { TestBed } from '@angular/core/testing';

import { UsernameServiceService } from './username-service.service';

describe('UsernameServiceService', () => {
  let service: UsernameServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UsernameServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

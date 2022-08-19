import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HardnsoftComponent } from './hardnsoft.component';

describe('HardnsoftComponent', () => {
  let component: HardnsoftComponent;
  let fixture: ComponentFixture<HardnsoftComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HardnsoftComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HardnsoftComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostTaskComponent } from './post-task.component';

describe('PostTaskComponent', () => {
  let component: PostTaskComponent;
  let fixture: ComponentFixture<PostTaskComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PostTaskComponent]
    });
    fixture = TestBed.createComponent(PostTaskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

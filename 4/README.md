# Task Management Service

This project is a system for managing tasks. With this application, you can create, search, and modify tasks, as well as manage their statuses.

## Features

### 1. **Create New Tasks**
- You can create tasks via the API. Each task will be saved in the database and have a unique identifier.
- To create a task, send a request with the `description` and `taskStatus` fields.

### 2. **View All Tasks**
- You can retrieve a list of all tasks available in the system.

### 3. **Search Tasks by Status**
- The system allows you to filter tasks by status (e.g., "NEW", "IN_PROGRESS", "COMPLETED"). This helps quickly find the tasks you need.
- Example: `api/tasks/in%20progress`

### 4. **Manage a Specific Task**
- You can retrieve a task by ID, delete it, or update the task's information.

## API for Task Management

### **Get All Tasks**

- **GET** `/api/tasks`

  **Response:**
  ```json
- List of tasks

        Response:
           {
             "id": 1,
             "description": "description of task",
             "taskStatus": "Task status"
            } ... 
            list of all tasks



## Get Tasks by Status
- GET /api/tasks/{status}
- Example: /api/tasks/in%20progress

        Response:
            {
             "id": 1,
             "description": "Description of task",
             "taskStatus": "{status}"
            } ... list of all tasks with status = {status}

### Create a New Task
--Example: POST: /api/tasks

        Request Body:
            {
             "description": "Description of task",
             "taskStatus": "Task status"
            }
        Response:
            {
             "id": 1,
             "description": "Updated description of task",
             "taskStatus": "Task status"
            }


## Specific Task
### GET Task: /api/tasks/{taskId} 

        Example: /api/tasks/1
        Response:
            {
             "id": 1,
             "description": "description of task",
             "taskStatus": "task status"
            }

## Update a Task
- PUT /api/tasks/{taskId}
- Example: /api/tasks/1

        Request Body:
            {
             "description": "Updated description of task",
             "taskStatus": "Updated task status"
            }
        Response:
            {
             "id": 1,
             "description": "Updated description of task",
             "taskStatus": "IN_PROGRESS"
            }
## Delete a Task
- DELETE /api/tasks/{taskId}
- Example: /api/tasks/1        


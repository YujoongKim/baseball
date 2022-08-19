-- **************************************************************
-- This script destroys the database and associated users
-- **************************************************************

-- The following line terminates any active connections to the database so that it can be destroyed
SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'golf_db';

DROP DATABASE golf_db;

DROP USER golf_db_owner;
DROP USER golf_db_appuser;
